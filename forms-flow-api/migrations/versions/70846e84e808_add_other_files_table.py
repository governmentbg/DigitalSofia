"""Add other-files table

Revision ID: 70846e84e808
Revises: 06820df4b451
Create Date: 2024-01-24 13:01:12.025264

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = '70846e84e808'
down_revision = '06820df4b451'
branch_labels = None
depends_on = None


def upgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.create_table('other_file',
    sa.Column('id', sa.Integer(), nullable=False),
    sa.Column('file_hash', sa.String(), nullable=False),
    sa.Column('file_name', sa.String(), nullable=False),
    sa.Column('file_mimetype', sa.String(), nullable=False),
    sa.Column('file_size', sa.Integer(), nullable=False),
    sa.Column('created_at', sa.DateTime(), nullable=False),
    sa.Column('client_id', sa.String(), nullable=False),
    sa.Column('application_id', sa.String(), nullable=True),
    sa.PrimaryKeyConstraint('id'),
    sa.UniqueConstraint('file_hash')
    )
    # ### end Alembic commands ###


def downgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.drop_table('other_file')
    # ### end Alembic commands ###